import { RoleEntity } from "./RoleEntity"

export type UserEntity = {
    id: string,
    name?: string,
    role?: RoleEntity
}