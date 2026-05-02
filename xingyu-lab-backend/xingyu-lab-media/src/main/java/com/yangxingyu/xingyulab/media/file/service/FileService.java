package com.yangxingyu.xingyulab.media.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yangxingyu.xingyulab.common.result.PageResult;
import com.yangxingyu.xingyulab.media.file.entity.SysFile;
import com.yangxingyu.xingyulab.media.file.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

public interface FileService extends IService<SysFile> {
    FileVO upload(MultipartFile file);
    PageResult<FileVO> pageList(int pageNum, int pageSize, String mimeType);
    void deleteFile(Long id);
}
