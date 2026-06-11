# android_dev_2a_listview
Visual effects for ListView items

## PART 1
This application demonstrates a custom **ListView** implementation in Android. It uses a `CustomAdapter` (extending `ArrayAdapter`) to bind a collection of cartoon names and captions to a custom row layout (`row.xml`).

### Technical Implementation Details
- **Dynamic Resource Access**: Instead of hardcoding resource IDs (e.g., `R.drawable.image`), the adapter uses `context.resources.getIdentifier()` to look up drawables by string name. This allows the data source to control which images are displayed.
- **View Inflation & Recycling**: The `getView` method implements basic view recycling. It checks if a `convertView` is available before inflating a new one, which optimizes memory usage and performance during scrolling.
- **ConstraintLayout in Lists**: The `row.xml` utilizes `ConstraintLayout` to create a responsive horizontal layout with an `ImageView` and `TextView`, ensuring consistent spacing across different screen sizes.

### Key Learning Points
- **The Adapter Pattern**: Learned how to extend `ArrayAdapter` to customize how data is mapped to UI components beyond simple text.
- **Inflating Layouts**: Understanding how the `LayoutInflater` service converts XML layout files into actual `View` objects programmatically.
- **Edge-to-Edge UI**: Implementing `enableEdgeToEdge()` and handling `WindowInsets` to ensure the app content properly fits under system bars (status and navigation) without being obscured.
- **Debugging Layouts**: Recognized the importance of setting `wrap_content` for row heights in a `ListView` to prevent a single item from occupying the entire screen.

