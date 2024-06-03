package blueprintjs.core

/**
 * Specifies the popup kind for [aria-haspopup](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/Attributes/aria-haspopup).
 */
external sealed class PopupKind {
    /** The popup is a menu. */
    object MENU : PopupKind
    /** The popup is a listbox. */
    object LISTBOX : PopupKind
    /** The popup is a tree. */
    object TREE : PopupKind
    /** The popup is a grid. */
    object GRID : PopupKind
    /** The popup is a dialog. */
    object DIALOG : PopupKind
}
