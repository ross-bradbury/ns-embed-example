import { NgModule, NO_ERRORS_SCHEMA } from "@angular/core";
import { NativeScriptModule } from "nativescript-angular/platform";

import { NativeScriptHttpModule } from "nativescript-angular/http";
import { NativeScriptRouterModule } from "nativescript-angular/router";
import { NativeScriptFormsModule } from "nativescript-angular/forms"

import { RootComponent } from "./root/root.component";
import { DemoPageComponent } from "./demo/demo-page.component";
import { WelcomeComponent } from "./welcome/welcome.component";

import { AppComponent } from "./app.component";

const authProviders = [
  //  AuthGuard
];

const appRoutes = [
  { path: "", component: RootComponent, pathMatch: "full" },
  { path: "demo", component: DemoPageComponent /*, canActivate: [AuthGuard] */ },
  { path: "welcome", component: WelcomeComponent /*, canActivate: [AuthGuard] */ }
];

@NgModule({
  providers: [
    authProviders
  ],
  declarations: [
    AppComponent,
    RootComponent,
    DemoPageComponent,
    WelcomeComponent
  ],
  imports: [
    NativeScriptModule,
    NativeScriptHttpModule,
    NativeScriptRouterModule,
    NativeScriptFormsModule,
    NativeScriptRouterModule.forRoot(appRoutes),
  ],
  bootstrap: [AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule { }
