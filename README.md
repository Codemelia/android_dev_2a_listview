# android_dev_2a_listview
Visual effects for ListView items

## PART 1
This application demonstrates a custom **ListView** implementation in Android. It uses a `CustomAdapter` (extending `ArrayAdapter`) to bind a collection of cartoon names and captions to a custom row layout (`row.xml`).

### Technical Implementation Details
- **Item Click Handling**: Implemented `AdapterView.OnItemClickListener` to detect when a user selects a specific row in the `ListView`. In its initial implementation, this triggers a `Toast` message displaying the item's caption.
- **Dynamic Resource Access**: Instead of hardcoding resource IDs (e.g., `R.drawable.image`), the adapter uses `context.resources.getIdentifier()` to look up drawables by string name. This allows the data source to control which images are displayed.
- **View Inflation & Recycling**: The `getView` method implements basic view recycling. It checks if a `convertView` is available before inflating a new one, which optimizes memory usage and performance during scrolling.
- **ConstraintLayout in Lists**: The `row.xml` utilizes `ConstraintLayout` to create a responsive horizontal layout with an `ImageView` and `TextView`, ensuring consistent spacing across different screen sizes.

### Key Learning Points
- **The Adapter Pattern**: Learned how to extend `ArrayAdapter` to customize how data is mapped to UI components beyond simple text.
- **Inflating Layouts**: Understanding how the `LayoutInflater` service converts XML layout files into actual `View` objects programmatically.
- **Edge-to-Edge UI**: Implementing `enableEdgeToEdge()` and handling `WindowInsets` to ensure the app content properly fits under system bars (status and navigation) without being obscured.
- **Debugging Layouts**: Recognized the importance of setting `wrap_content` for row heights in a `ListView` to prevent a single item from occupying the entire screen.

## PART 2
This section focuses on user interaction and dynamic UI updates when list items are clicked.

### Technical Implementation Details
- **State Management**: Used member variables (`prevRow`, `prevTextView`, `prevCaption`) to track the previously selected item. This allows the app to reset the state of the old selection before highlighting the new one.
- **Dynamic Styling**: 
    - **Text Manipulation**: Programmatically changing text to uppercase and applying a bold `Typeface`.
    - **Row Highlighting**: Changing the background color of the clicked `View` to provide visual feedback.
- **Resource Restoration**: Ensured that when a new item is clicked, the previous item's background is set back to transparent and its text is restored to its original case and weight.

### Key Learning Points
- **ListView Interactivity**: How to move beyond a static list to a responsive UI that reacts to user input.
- **Memory of UI State**: Understanding how to store references to `View` objects to manage transitions between different visual states.
- **Visual Feedback Design**: Implementing simple but effective cues (color changes, font weight) to improve user experience.


