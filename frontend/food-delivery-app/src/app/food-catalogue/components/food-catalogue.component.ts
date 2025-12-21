import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItemService } from '../service/foodItem.service';
import { FoodCataloguePage } from '../../shared/models/FoodCataloguePage';
import { FoodItem } from '../../shared/models/FoodItem';

@Component({
  selector: 'app-food-catalogue',
  standalone: false,
  templateUrl: './food-catalogue.component.html',
  styleUrl: './food-catalogue.component.css'
})
export class FoodCatalogueComponent {

  restaurantId: number;
  foodItemResponse: FoodCataloguePage;
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCataloguePage;
  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router: Router) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.restaurantId = +params.get('id')!;
      if (this.restaurantId && !isNaN(this.restaurantId)) {
        this.getFoodItemsByRestaurantId(this.restaurantId);
      } else {
        this.errorMessage = 'Invalid restaurant ID';
      }
    });
  }

  getFoodItemsByRestaurantId(restaurantId: number) {
    this.isLoading = true;
    this.errorMessage = '';
    
    setTimeout(() => {
      this.foodItemService.getFoodItemsByRestaurant(restaurantId).subscribe({
        next: (data) => {
          this.foodItemResponse = data;
          this.isLoading = false;
        },
        error: (error) => {
          this.errorMessage = error.message || 'Failed to load food items. Please try again.';
          this.isLoading = false;
        }
      });
    }, 500);
  }

  increment(food: any) {
    if (!food.quantity) {
      food.quantity = 0;
    }
    food.quantity++;
    const index = this.foodItemCart.findIndex(item => item.id == food.id);
    if(index == -1){
      this.foodItemCart.push(food);
    }
    else{
      this.foodItemCart[index] = food;
    }
  }

  decrement(food: any) {
    if(food.quantity && food.quantity > 0) {
        food.quantity--;
        const index = this.foodItemCart.findIndex(item => item.id == food.id);
        if(index !== -1 && this.foodItemCart[index].quantity == 0){
          this.foodItemCart.splice(index, 1);
        }
        else if(index !== -1){
          this.foodItemCart[index] = food;
        }
    }
  }

  onCheckOut() {
    this.orderSummary = {
      foodItemsList: this.foodItemCart,
      restaurant: this.foodItemResponse?.restaurant
    }
    
    console.log('Order Summary:', this.orderSummary);
    this.router.navigate(['/orderSummary'], { queryParams: {data: JSON.stringify(this.orderSummary) } });
  }

}
