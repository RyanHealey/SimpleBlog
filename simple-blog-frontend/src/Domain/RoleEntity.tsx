import { PermissionType } from "./PermissionType"

export type RoleEntity = {
    id: string,
    name?: string,
    permissions?: PermissionType
}