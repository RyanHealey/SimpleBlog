import { CurrentUserDto } from "../Domain/CurrentUserDto";
import { CurrentUserEntity } from "../Domain/CurrentUserEntity";

export class CurrentUserApi {
    
    getCurrentUser() : Promise<CurrentUserDto> {
        return this.sendRequest("/current","GET",null)
                .then(res => res.json());
    }

    updateCurrentUser(id :string) : Promise<CurrentUserDto> {
        return this.sendRequest("/current/"+id,"GET",null)
                .then(res => res.json());
    }


    protected sendRequest(url: string, method:string, body:string | null) : Promise<Response>{
        const options:RequestInit = {
            method: method,
            headers:{'content-type': 'application/json'},
            body: body
          };

          return fetch(url, options);
    }

}