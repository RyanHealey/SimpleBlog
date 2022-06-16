import { UserEntity } from "./UserEntity"

export type PostEntity = {
    id: string,
    content?: string,
    user?: UserEntity
}