import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: false,
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  username: string = "Profile User";
  userProfilePic: string = "/assets/avatar-pics/user-logo.jpg";
  isSidebarOpen: boolean = false;
  imageError: boolean = false;

  constructor(private router: Router) {}

  toggleSidebar() {
    this.isSidebarOpen = !this.isSidebarOpen;
    if (this.isSidebarOpen) {
      document.body.style.overflow = 'hidden';
    } else {
      document.body.style.overflow = 'auto';
    }
  }

  closeSidebar() {
    this.isSidebarOpen = false;
    document.body.style.overflow = 'auto';
  }

  goHome() {
    this.router.navigate(['/']);
  }

  onImageError(event: any) {
    if (!this.imageError) {
      console.error('Failed to load profile picture');
      this.imageError = true;
      event.target.src = "https://via.placeholder.com/150";
    }
  }
}
