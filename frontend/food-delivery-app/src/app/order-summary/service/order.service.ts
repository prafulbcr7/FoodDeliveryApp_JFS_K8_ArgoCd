import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, delay } from 'rxjs/operators';
//import { API_URL_Order } from '../../constants/url';
import { K8_External_IP } from '../../constants/url';

@Injectable({
    providedIn: 'root'
})

export class OrderService {

    //private apiUrl = API_URL_Order + '/order/addOrder';
    private apiUrl = K8_External_IP + '/order/addOrder';

    constructor(private http: HttpClient) {}

    httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'text/plain',
            'Access-Control-Allow-Origin': 'http://localhost:4200' // Angular Application URL
        })
    };

    addOrder(data: any):Observable<any> {
        return this.http.post<any>(this.apiUrl, data);
    }

    private handleError(error: any) {
        console.error('An error occurred:', error);
        return throwError(() => new Error(error.message || error));
    }

}