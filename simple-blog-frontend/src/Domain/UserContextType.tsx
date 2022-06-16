import { CurrentUserEntity } from "./CurrentUserEntity"

export type UserContextType = {
    currentUser: CurrentUserEntity,
    setCurrentUser: CallableFunction
}