import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse, HttpErrorResponse, HttpHeaderResponse } from '@angular/common/http';
import { Observable, throwError, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) {}

  getWorkflows(): Observable<Repository[]> {
    const response = this.http.get<Repository[]>('/api/github/workflows');
    return response.pipe(map(data => data));
  }

  getRepositories(): Observable<string[]> {
    const response = this.http.get<string[]>('/api/github/repos');
    return response.pipe(map(data => data));
  }

  getUser(): Observable<User> {
    const response = this.http.get<OAuth2User>('/user/whoami', {observe: 'response'});
    const user = response.pipe(map(data => {
      console.log('response', data);
      if (data.status === 401) {
        return {};
      } else {
        return {
          name: data.body.attributes.login,
          avatar: data.body.attributes.avatar_url
        };
      }
    }));
    return user;
  }

  logout(): Observable<boolean> {
    return this.http.post<HttpResponse<string>>('/logout', null).pipe(
      map(r => {
          return true;
        }),
      catchError(this.handleError)
    );
  }


  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`, error);
    }
    // return an observable with a user-facing error message
    return of(false);
    // return throwError(
    //   'Something bad happened; please try again later.');
  }

}

export interface CheckRun {
  name: string;
  status: string;
  conclusion: string;
  url: string;
}

export interface PullRequest {
  name: string;
  number: number;
  url: string;
  checkRuns: CheckRun[];
}

export interface Branch {
  name: string;
  checkRuns: CheckRun[];
}

export interface Repository {
  owner: string;
  name: string;
  branches: Branch[];
  pullRequests: PullRequest[];
}

export interface User {
  name?: string;
  avatar?: string;
}

interface OAuth2User {
  attributes: {
    login: string;
    avatar_url: string
  };
}
