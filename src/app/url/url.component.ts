import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UrlServiceService } from '../service/url-service.service';
import { URL } from './url';

@Component({
  selector: 'app-url',
  templateUrl: './url.component.html',
  styleUrls: ['./url.component.scss']
})
export class UrlComponent {

constructor(private urlServiceService: UrlServiceService){}
urlObject :URL = new URL();
urlForm = new FormGroup({
  inputUrl: new FormControl()
});
  generateShortLink(){
    let orginalUrl: string = this.urlForm.get('inputUrl')?.value;
    console.log(orginalUrl);
 
   this.urlObject.url = orginalUrl;

     this.urlServiceService.generateShortLink(orginalUrl).subscribe


  }
}
