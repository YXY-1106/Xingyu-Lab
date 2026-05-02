/** 统一响应结构 */
export interface Result<T = any> {
  code: number
  message: string
  data: T
}

/** 分页响应 */
export interface PageResult<T = any> {
  records: T[]
  total: number
  page: number
  size: number
}

/** 分页请求参数 */
export interface PageQuery {
  page?: number
  size?: number
}

/** 内容可见性 */
export type Visibility = 'public' | 'login' | 'private' | 'couple'

/** 内容状态 */
export type Status = 'draft' | 'published' | 'hidden'
