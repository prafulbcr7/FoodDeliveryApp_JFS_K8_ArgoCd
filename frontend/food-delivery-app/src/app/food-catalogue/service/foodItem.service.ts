import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry, delay } from 'rxjs/operators';
//import { API_URL_FC } from '../../constants/url';
import { K8_External_IP } from '../../constants/url';

@Injectable({
    providedIn: 'root'
})

export class FoodItemService {

    //private apiUrl = API_URL_FC + '/foodCatalogue/getRestaurantsFoodItemsById/';
    private apiUrl = K8_External_IP + '/foodCatalogue/getRestaurantsFoodItemsById/';

    constructor(private http: HttpClient) {}

    getFoodItemsByRestaurant(id: number): Observable<any> {
        return this.http.get<any>(`${this.apiUrl+ id}`)
            .pipe(
                catchError(this.handleError)
            );
    }

    private handleError(error: any) {
        console.error('An error occurred:', error);
        return throwError(() => new Error(error.message || error));
    }

}