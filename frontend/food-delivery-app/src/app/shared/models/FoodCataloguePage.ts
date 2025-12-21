import { Restaurant } from "./Restaurant";
import { FoodItem } from "./FoodItem";

export interface FoodCataloguePage {
    restaurant?: Restaurant;
    foodItemsList?: FoodItem[];
}