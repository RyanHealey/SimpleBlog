import { PostEntity } from "./PostEntity"
import { UserEntity } from "./UserEntity"

export type CommentEntity = {
    id?: string,
    content?: string,
    user?: UserEntity,
    post?: PostEntity
}