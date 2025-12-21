import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'restaurant-listing', pathMatch: 'full' },
  { 
    path: 'restaurant-listing', 
    loadChildren: () => import('./restaurant-listing/restaurant-listing.module').then(m => m.RestaurantListingModule)
  },
  {
    path: 'food-catalogue',
    loadChildren: () => import('./food-catalogue/food-catalogue.module').then(m => m.FoodCatalogueModule)
  },
  {
    path: 'orderSummary',
    loadChildren: () => import('./order-summary/order-summary.module').then(m => m.OrderSummaryModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
