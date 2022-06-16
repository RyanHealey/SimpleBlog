import React, { createContext, useEffect, useState } from 'react';
import './App.css';
import CreatePostContainer from './Components/Posts/CreatePostContainer';
import Login from './Components/Posts/Login';
import Posts from './Components/Posts/Posts';
import { mapToCurrentUserEntity } from './Domain/CurrentUserDto';
import { CurrentUserEntity } from './Domain/CurrentUserEntity';
import { UserContextType } from './Domain/UserContextType';
import { CurrentUserApi } from './Service/CurrentUserApi';
import { hasPermissionToWritePost } from './Service/PermissionsService';


const currentApi: CurrentUserApi = new CurrentUserApi();

const defaultUserContext:UserContextType = 
{
  currentUser : {
    id:"1",
    name:"",
    role:{
      id:"1",
      name:"Default"
    }
  },
  setCurrentUser : () => {}
}
export const UserContext = createContext<UserContextType>(defaultUserContext);



function App() {
  const [currentUser, setCurrentUser] = useState<CurrentUserEntity>(defaultUserContext.currentUser);

  useEffect(() => {currentApi.getCurrentUser().then(res => setCurrentUser(mapToCurrentUserEntity(res)));},[])
  return (
    <div>
      <p>Currently logged in as {currentUser.name}</p>
      <UserContext.Provider value = {{currentUser: currentUser, setCurrentUser: setCurrentUser}}>
        <Login/>
        {hasPermissionToWritePost(currentUser)?<CreatePostContainer/>:null}
        <div>
          <Posts/>
        </div>
      </UserContext.Provider>
    </div>
  );
}

export default App;
