import { Component, OnInit } from "@angular/core";
import { RouterExtensions } from "nativescript-angular";
import { Page } from "ui/page";
import * as appSettings from "application-settings";

@Component({
    selector: "my-app",
    template: "<StackLayout></StackLayout>",
})
export class RootComponent implements OnInit {

    constructor(private routerExtensions: RouterExtensions, private page: Page) {
        console.log("RootComponent constructor");
    }
    
    ngOnInit() {
        console.log("RootComponent ngOnInit");

        var route = "/welcome";

        try {
            var r = appSettings.getString("initialRoute");
            console.log(r);
            route = r;
        } catch (e) {
            console.log(e);
        }
    
        this.routerExtensions.navigate([route], { clearHistory: true });
    }
}
