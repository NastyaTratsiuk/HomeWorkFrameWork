package pages;

import elements.BaseElement;

public abstract class BasePage {

    BaseElement baseElement;

    public BasePage(BaseElement baseElement) {
        this.baseElement = baseElement;
    }

    public BaseElement getBaseElement() {
        return baseElement;
    }

    public abstract boolean isDisplay();

}
