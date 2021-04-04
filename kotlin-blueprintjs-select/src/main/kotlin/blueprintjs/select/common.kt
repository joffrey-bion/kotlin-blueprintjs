@file:JsModule("@blueprintjs/select")

package blueprintjs.select

import blueprintjs.core.AbstractPureComponent2
import blueprintjs.core.IInputGroupProps2
import blueprintjs.core.IPopoverProps
import blueprintjs.core.IProps
import org.w3c.dom.HTMLElement
import react.PureComponent
import react.RState
import react.ReactElement

external interface IListItemsProps<T> : IProps {
    var activeItem: dynamic /* T? | ICreateNewItem? */
    var items: Array<T>
    var itemsEqual: dynamic /* ItemsEqualComparator<T>? | Any */
    var itemDisabled: dynamic /* Any | ((item: T, index: Number) -> Boolean)? */
    var itemListPredicate: ItemListPredicate<T>?
    var itemPredicate: ItemPredicate<T>?
    var itemRenderer: ItemRenderer<T>
    var itemListRenderer: ItemListRenderer<T>?
    var initialContent: Any?
    var noResults: Any?
    var onActiveItemChange: ((activeItem: T?, isCreateNewItem: Boolean) -> Unit)?
    var onItemSelect: (item: T, event: Event) -> Unit
    var onItemsPaste: ((items: Array<T>) -> Unit)?
    var onQueryChange: ((query: String, event: ChangeEventHandler<HTMLInputElement>) -> Unit)?
    var createNewItemFromQuery: ((query: String) -> T)?
    var createNewItemRenderer: ((query: String, active: Boolean, handleClick: react.MouseEventHandler<HTMLElement>) -> dynamic)?
    var createNewItemPosition: String? /* "first" | "last" */
    var resetOnQuery: Boolean?
    var resetOnSelect: Boolean?
    var scrollToActiveItem: Boolean?
    var query: String?
}

external interface IListItemsPropsPartial<T> : IProps {
}

external fun <T> executeItemsEqual(itemsEqualProp: ItemsEqualComparator<T>?, itemA: T?, itemB: T?): Boolean

external fun <T> executeItemsEqual(itemsEqualProp: Any, itemA: T?, itemB: T?): Boolean