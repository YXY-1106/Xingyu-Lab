package com.yangxingyu.xingyulab.media.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yangxingyu.xingyulab.common.exception.BusinessException;
import com.yangxingyu.xingyulab.common.exception.ErrorCode;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.media.file.entity.SysFile;
import com.yangxingyu.xingyulab.media.file.mapper.SysFileMapper;
import com.yangxingyu.xingyulab.media.file.service.FileService;
import com.yangxingyu.xingyulab.media.file.vo.FileVO;
import com.yangxingyu.xingyulab.media.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements FileService {

    private final StorageService storageService;

    @Override
    public FileVO upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new BusinessException(ErrorCode.FILE_UPLOAD_FAIL);
        }
        String originalName = file.getOriginalFilename();
        String ext = StringUtils.getFilenameExtension(originalName);
        String datePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + ext;
        String filePath = datePath + "/" + fileName;

        String url;
        try {
            url = storageService.upload(filePath, file.getInputStream());
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.FILE_UPLOAD_FAIL);
        }

        SysFile sysFile = new SysFile();
        sysFile.setOriginalName(originalName);
        sysFile.setFileName(fileName);
        sysFile.setFilePath(filePath);
        sysFile.setUrl(url);
        sysFile.setFileSize(file.getSize());
        sysFile.setMimeType(file.getContentType());
        sysFile.setStorageType(storageService.getStorageType());
        sysFile.setStatus(0);
        this.save(sysFile);

        return toVO(sysFile);
    }

    @Override
    public PageResult<FileVO> pageList(int pageNum, int pageSize, String mimeType) {
        LambdaQueryWrapper<SysFile> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(mimeType), SysFile::getMimeType, mimeType);
        wrapper.orderByDesc(SysFile::getCreateTime);
        Page<SysFile> page = this.page(new Page<>(pageNum, pageSize), wrapper);
        return new PageResult<>(page.getTotal(), page.getRecords().stream().map(this::toVO).toList());
    }

    @Override
    public void deleteFile(Long id) {
        this.removeById(id);
    }

    private FileVO toVO(SysFile file) {
        FileVO vo = new FileVO();
        BeanUtils.copyProperties(file, vo);
        return vo;
    }
}
