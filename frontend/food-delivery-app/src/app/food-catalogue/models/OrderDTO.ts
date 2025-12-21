import { Restaurant } from "../../shared/models/Restaurant";
import { FoodItem } from "../../shared/models/FoodItem";

export interface OrderDTO {
    userId?: number;
    restaurant?: Restaurant;
    foodItemList?: FoodItem[];
}