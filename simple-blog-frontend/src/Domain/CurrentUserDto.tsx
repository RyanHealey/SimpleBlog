import { CurrentUserEntity } from "./CurrentUserEntity"

export type CurrentUserDto = {
    user: CurrentUserEntity
}

export const mapToCurrentUserEntity = (dto :CurrentUserDto) : CurrentUserEntity => {
    return dto.user
}
