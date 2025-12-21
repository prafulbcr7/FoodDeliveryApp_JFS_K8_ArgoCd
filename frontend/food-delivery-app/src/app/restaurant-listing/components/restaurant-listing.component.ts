import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from '../../shared/models/Restaurant';
import { RestaurantService } from '../service/restaurant.service';

@Component({
  selector: 'app-restaurant-listing',
  standalone: false,
  templateUrl: './restaurant-listing.component.html',
  styleUrl: './restaurant-listing.component.css'
})
export class RestaurantListingComponent {

  public restaurantList: Restaurant[];
  public restaurantImages: { [key: number]: string } = {};

  ngOnInit() {
    this.getAllRestaurants();
  }

  constructor(private router: Router, private restaurantService: RestaurantService) {}

  getAllRestaurants() {
    this.restaurantService.getAllRestaurants().subscribe(
      data => {
        this.restaurantList = data;
        this.restaurantList.forEach(restaurant => {
          if (restaurant.id) {
            this.restaurantImages[restaurant.id] = this.getRandomImage();
          }
        });
      }
    )
  }

  getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  getRandomImage() : string {
    const imageCount = 10;
    const randomIndex = this.getRandomNumber(1, imageCount);
    return `${randomIndex}.png`;
  }

  onButtonClick(id: number) {
    this.router.navigate(['/food-catalogue', id]);
  }

}
