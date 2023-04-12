import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { URL } from '../url/url';

@Injectable({
  providedIn: 'root'
})
export class UrlServiceService {

  private baseUrl = "http://localhost:8080/myapp";
  constructor(private http: HttpClient) { }

  generateShortLink(orginalUrl: string): Observable<string>{
    let url:string = this.baseUrl+"url/shortenUrl";
    return this.http.get<string>(`${url}/${orginalUrl}`);
  }

  connect():Observable<string>{
    let url:string = this.baseUrl+"url/urlcontroller";
    let res =  this.http.get<string>(url);
    alert(res.subscribe)
    return res;
  }
}
