import { CommentEntity } from "../Domain/CommentEntity"
import { CurrentUserEntity } from "../Domain/CurrentUserEntity";
import { permission, PermissionType } from "../Domain/PermissionType";
import { PostEntity } from "../Domain/PostEntity"

const enum permissionLevel {
    NONE = 1,
    Read = 2,
    CREATE = 3,
    EDIT = 4
}

const defaultPermissions :PermissionType = 
{
    1:0,
    2:0,
    3:0
}

export const hasPermissionToDeletePost = (post:PostEntity, user:CurrentUserEntity): boolean => {
    return (getPermissions(user)[permission.Posts]?? 0) >= permissionLevel.EDIT 
    && (post.user ?? {id:-1}).id  === user.id;
}

export const hasPermissionToDeleteComment = (comment: CommentEntity, user: CurrentUserEntity): boolean => {
    return (getPermissions(user)[permission.Comments] ?? 0) >= permissionLevel.EDIT;
}

export const hasPermissionToWritePost = (user: CurrentUserEntity): boolean => {
    return (getPermissions(user)[permission.Posts] ?? 0) >= permissionLevel.CREATE;

}

export const hasPermissionToWriteComment = (user: CurrentUserEntity): boolean => {
    return (getPermissions(user)[permission.Comments] ?? 0) >= permissionLevel.CREATE;

}

const getPermissions = (user: CurrentUserEntity): PermissionType => {
    return user.role.permissions ?? defaultPermissions;
}