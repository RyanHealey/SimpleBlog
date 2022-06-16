export type RoleEntity = {
    id: string,
    name?: string,
    permissions?: Map<number,number>
}