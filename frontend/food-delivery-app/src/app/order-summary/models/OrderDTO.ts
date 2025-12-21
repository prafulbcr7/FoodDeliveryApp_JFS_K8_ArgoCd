import { FoodItem } from "../../shared/models/FoodItem";
import { Restaurant } from "../../shared/models/Restaurant";

export interface OrderDTO {
    userId?: number;
    restaurant: Restaurant;
    foodItemList: FoodItem[];
}