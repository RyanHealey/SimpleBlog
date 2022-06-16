import React, { useContext, useEffect } from "react";
import { FormEvent, ReactElement, useState } from "react"
import { UserContext } from "../../App";
import { mapToCurrentUserEntity } from "../../Domain/CurrentUserDto";
import { UserContextType } from "../../Domain/UserContextType";
import { UserEntity } from "../../Domain/UserEntity";
import { CurrentUserApi } from "../../Service/CurrentUserApi";
import { UserApiService } from "../../Service/UserApiService";

const userApi: UserApiService = new UserApiService();
const currentApi: CurrentUserApi = new CurrentUserApi();

function Login () : ReactElement{
    const currentUser:UserContextType = useContext(UserContext);
    const form: HTMLFormElement | null = document.querySelector('#usersSelect');

    const [users,setUsers] = useState<Array<UserEntity>>([])

    const onSubmit = (e:FormEvent<HTMLFormElement>):void => {
        e.preventDefault();
        const formData: FormData = new FormData(form ?? undefined);
        currentApi.updateCurrentUser(formData.get('users')?.toString() ?? "")
        .then(res => currentUser.setCurrentUser(mapToCurrentUserEntity(res)));
    }

    const formatUser = (user: UserEntity) : ReactElement => {
        return(
            <option value={user.id}>{user.name}</option>
        )
    }

    const formatUsers = (users: Array<UserEntity>) : ReactElement => {
        users.map((user)=> formatUser(user))
        return(
            <React.Fragment>
                {users.map((user)=> formatUser(user))}
            </React.Fragment>
        )
    }

    useEffect(() => {
        userApi.getAll().then(res => {setUsers(res)});    
    },[]);



    return(
        <form onSubmit={onSubmit} id="usersSelect">
            <select name="users">
                {formatUsers(users)}
            </select>
            <button type = "submit">Login</button>
        </form>
    )
}
export default Login

