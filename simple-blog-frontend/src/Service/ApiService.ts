
export abstract class ApiService<T>{

    endpoint:string;

    constructor(endpoint:string){
        this.endpoint = endpoint;
    }

    getAll = () : Promise<Array<T>> => {
        return this.sendRequest('/'+this.endpoint,'GET',null)
         .then(res => res.json());
    }

    getById = (id : string): Promise<T> => {
        return this.sendRequest('/'+this.endpoint+'/'+id,'GET',null)
        .then(res => res.json());
    }

    postNew = (body : T) : Promise<Response> => {
        return this.sendRequest('/'+this.endpoint,'POST',JSON.stringify(body));
    }

    delete = (id : string): void => {
        this.sendRequest('/'+this.endpoint+'/'+id,'DELETE',null)
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