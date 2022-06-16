import { RoleEntity } from "./RoleEntity"

export type CurrentUserEntity = {
    id: string,
    name: string,
    role: RoleEntity
}