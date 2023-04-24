import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { StorageService } from './services/storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'touristy';

  constructor(
    private storageService: StorageService,
    private authService: AuthService
  ) {
    if (this.storageService.getLocalItem('isLoggedIn')) {
      this.authService.isAuthenticated = true;
    }
  }
}
