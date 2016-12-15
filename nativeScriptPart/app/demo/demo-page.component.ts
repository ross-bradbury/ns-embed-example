import { Component, ViewContainerRef } from '@angular/core';
import { ModalDialogService, ModalDialogOptions } from "nativescript-angular/modal-dialog";

import { Page } from "ui/page";
@Component({
    selector: "my-app",
    templateUrl: "./demo/demo-page.component.html",
})
export class DemoPageComponent {
    constructor(
        private modalService: ModalDialogService,
        private viewContainerRef: ViewContainerRef) { }

    public counter: number = 16;
    public myDate = new Date(2015,2,3);
    public model = { depositedTo:"that place"};

    public get message(): string {
        if (this.counter > 0) {
            return this.counter + " taps left";
        } else {
            return "Hoorraaay! \nYou are ready to start building!";
        }
    }

    public onTap() {
        this.counter--;
    }
}
