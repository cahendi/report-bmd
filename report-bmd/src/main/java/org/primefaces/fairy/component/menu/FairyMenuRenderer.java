package org.primefaces.fairy.component.menu;

import org.primefaces.util.WidgetBuilder;
import java.util.Map;
import javax.faces.component.UIForm;
import org.primefaces.component.api.AjaxSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.faces.FacesException;
import org.primefaces.util.ComponentUtils;
import org.primefaces.component.api.UIOutcomeTarget;
import org.primefaces.model.menu.Separator;
import org.primefaces.model.menu.Submenu;
import org.primefaces.model.menu.MenuItem;
import java.io.IOException;
import javax.faces.context.ResponseWriter;
import org.primefaces.model.menu.MenuElement;
import java.util.List;
import javax.faces.component.UIComponent;
import org.primefaces.component.menu.AbstractMenu;
import javax.faces.context.FacesContext;
import org.primefaces.component.menu.BaseMenuRenderer;

public class FairyMenuRenderer extends BaseMenuRenderer
{
    protected void encodeMarkup(final FacesContext context, final AbstractMenu abstractMenu) throws IOException {
        final FairyMenu menu = (FairyMenu)abstractMenu;
        final ResponseWriter writer = context.getResponseWriter();
        final String style = menu.getStyle();
        String styleClass = menu.getStyleClass();
        styleClass = ((styleClass == null) ? "layout-menu" : ("layout-menu " + styleClass));
        writer.startElement("ul", (UIComponent)menu);
        writer.writeAttribute("id", (Object)menu.getClientId(context), "id");
        writer.writeAttribute("class", (Object)styleClass, "styleClass");
        if (style != null) {
            writer.writeAttribute("style", (Object)style, "style");
        }
        if (menu.getElementsCount() > 0) {
            this.encodeElements(context, menu, menu.getElements());
        }
        writer.endElement("ul");
    }

    protected void encodeElements(final FacesContext context, final AbstractMenu menu, final List<MenuElement> elements) throws IOException {
        for (int size = elements.size(), i = 0; i < size; ++i) {
            this.encodeElement(context, menu, elements.get(i));
        }
    }

    protected void encodeElement(final FacesContext context, final AbstractMenu menu, final MenuElement element) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();
        if (element.isRendered()) {
            if (element instanceof MenuItem) {
                final MenuItem menuItem = (MenuItem)element;
                final String menuItemClientId = (menuItem instanceof UIComponent) ? menuItem.getClientId() : (menu.getClientId(context) + "_" + menuItem.getClientId());
                final String containerStyle = menuItem.getContainerStyle();
                final String containerStyleClass = menuItem.getContainerStyleClass();
                writer.startElement("li", (UIComponent)null);
                writer.writeAttribute("id", (Object)menuItemClientId, (String)null);
                writer.writeAttribute("role", (Object)"menuitem", (String)null);
                if (containerStyle != null) {
                    writer.writeAttribute("style", (Object)containerStyle, (String)null);
                }
                if (containerStyleClass != null) {
                    writer.writeAttribute("class", (Object)containerStyleClass, (String)null);
                }
                this.encodeMenuItem(context, menu, menuItem);
                writer.endElement("li");
            }
            else if (element instanceof Submenu) {
                final Submenu submenu = (Submenu)element;
                final String submenuClientId = (submenu instanceof UIComponent) ? ((UIComponent)submenu).getClientId() : (menu.getClientId(context) + "_" + submenu.getId());
                final String style = submenu.getStyle();
                final String styleClass = submenu.getStyleClass();
                writer.startElement("li", (UIComponent)null);
                writer.writeAttribute("id", (Object)submenuClientId, (String)null);
                writer.writeAttribute("role", (Object)"menuitem", (String)null);
                if (style != null) {
                    writer.writeAttribute("style", (Object)style, (String)null);
                }
                if (styleClass != null) {
                    writer.writeAttribute("class", (Object)styleClass, (String)null);
                }
                this.encodeSubmenu(context, menu, submenu);
                writer.endElement("li");
            }
            else if (element instanceof Separator) {
                this.encodeSeparator(context, (Separator)element);
            }
        }
    }

    protected void encodeSubmenu(final FacesContext context, final AbstractMenu menu, final Submenu submenu) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();
        final String icon = submenu.getIcon();
        final String label = submenu.getLabel();
        final int childrenElementsCount = submenu.getElementsCount();
        writer.startElement("a", (UIComponent)null);
        writer.writeAttribute("href", (Object)"#", (String)null);
        this.encodeItemIcon(context, icon);
        if (label != null) {
            writer.startElement("span", (UIComponent)null);
            writer.writeText((Object)label, (String)null);
            writer.endElement("span");
            this.encodeToggleIcon(context, submenu, childrenElementsCount);
        }
        writer.endElement("a");
        if (childrenElementsCount > 0) {
            writer.startElement("ul", (UIComponent)null);
            writer.writeAttribute("role", (Object)"menu", (String)null);
            this.encodeElements(context, menu, submenu.getElements());
            writer.endElement("ul");
        }
    }

    protected void encodeItemIcon(final FacesContext context, String icon) throws IOException {
        if (icon != null) {
            final ResponseWriter writer = context.getResponseWriter();
            writer.startElement("i", (UIComponent)null);
            if (icon.contains("fa ")) {
                icon += " fa-fw";
            }
            writer.writeAttribute("class", (Object)icon, (String)null);
            writer.endElement("i");
        }
    }

    protected void encodeToggleIcon(final FacesContext context, final Submenu submenu, final int childrenElementsCount) throws IOException {
        if (childrenElementsCount > 0) {
            final ResponseWriter writer = context.getResponseWriter();
            writer.startElement("i", (UIComponent)null);
            writer.writeAttribute("class", (Object)"fa fa-fw fa-angle-down menuitem-toggle-icon", (String)null);
            writer.endElement("i");
        }
    }

    protected void encodeSeparator(final FacesContext context, final Separator separator) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();
        final String style = separator.getStyle();
        String styleClass = separator.getStyleClass();
        styleClass = ((styleClass == null) ? "Separator" : ("Separator " + styleClass));
        writer.startElement("li", (UIComponent)null);
        writer.writeAttribute("class", (Object)styleClass, (String)null);
        if (style != null) {
            writer.writeAttribute("style", (Object)style, (String)null);
        }
        writer.endElement("li");
    }

    protected void encodeMenuItem(final FacesContext context, final AbstractMenu menu, final MenuItem menuitem) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();
        final String title = menuitem.getTitle();
        final boolean disabled = menuitem.isDisabled();
        final String style = menuitem.getStyle();
        final String styleClass = menuitem.getStyleClass();
        writer.startElement("a", (UIComponent)null);
        if (title != null) {
            writer.writeAttribute("title", (Object)title, (String)null);
        }
        if (style != null) {
            writer.writeAttribute("style", (Object)style, (String)null);
        }
        if (styleClass != null) {
            writer.writeAttribute("class", (Object)styleClass, (String)null);
        }
        if (disabled) {
            writer.writeAttribute("href", (Object)"#", (String)null);
            writer.writeAttribute("onclick", (Object)"return false;", (String)null);
        }
        else {
            this.setConfirmationScript(context, menuitem);
            String onclick = menuitem.getOnclick();
            if (menuitem.getUrl() != null || menuitem.getOutcome() != null) {
                final String targetURL = this.getTargetURL(context, (UIOutcomeTarget)menuitem);
                writer.writeAttribute("href", (Object)targetURL, (String)null);
                if (menuitem.getTarget() != null) {
                    writer.writeAttribute("target", (Object)menuitem.getTarget(), (String)null);
                }
            }
            else {
                writer.writeAttribute("href", (Object)"#", (String)null);
                final UIComponent form = ComponentUtils.findParentForm(context, (UIComponent)menu);
                if (form == null) {
                    throw new FacesException("MenuItem must be inside a form element");
                }
                String command = null;
                if (menuitem.isDynamic()) {
                    final String menuClientId = menu.getClientId(context);
                    Map<String, List<String>> params = (Map<String, List<String>>)menuitem.getParams();
                    if (params == null) {
                        params = new LinkedHashMap<String, List<String>>();
                    }
                    final List<String> idParams = new ArrayList<String>();
                    idParams.add(menuitem.getId());
                    params.put(menuClientId + "_menuid", idParams);
                    command = (menuitem.isAjax() ? this.buildAjaxRequest(context, (UIComponent)menu, (AjaxSource)menuitem, (UIForm)form, (Map)params) : this.buildNonAjaxRequest(context, (UIComponent)menu, form, menuClientId, (Map)params, true));
                }
                onclick = ((onclick == null) ? command : (onclick + ";" + command));
            }
            if (onclick != null) {
                if (menuitem.requiresConfirmation()) {
                    writer.writeAttribute("data-pfconfirmcommand", (Object)onclick, (String)null);
                    writer.writeAttribute("onclick", (Object)menuitem.getConfirmationScript(), "onclick");
                }
                else {
                    writer.writeAttribute("onclick", (Object)onclick, (String)null);
                }
            }
        }
        this.encodeMenuItemContent(context, menu, menuitem);
        writer.endElement("a");
    }

    protected void encodeMenuItemContent(final FacesContext context, final AbstractMenu menu, final MenuItem menuitem) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();
        final String icon = menuitem.getIcon();
        final Object value = menuitem.getValue();
        this.encodeItemIcon(context, icon);
        if (value != null) {
            writer.startElement("span", (UIComponent)null);
            writer.writeText(value, "value");
            writer.endElement("span");
        }
    }

    protected void encodeScript(final FacesContext context, final AbstractMenu abstractMenu) throws IOException {
        final FairyMenu menu = (FairyMenu)abstractMenu;
        final String clientId = menu.getClientId(context);
        final WidgetBuilder wb = this.getWidgetBuilder(context);
        wb.init("Fairy", menu.resolveWidgetVar(), clientId).finish();
    }
}