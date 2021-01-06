# zoomRecycylerView Layout

## Dependency

[Github Link](https://github.com/Spikeysanju/ZoomRecylerLayout)

Module Gradle
```xml
  implementation 'com.github.Spikeysanju:ZoomRecylerLayout:1.0'
```

Remember to add maven url:

```xml
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

## Usage

```kotlin
val linearLayoutManager = ZoomRecyclerLayout(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        linearLayoutManager.reverseLayout = true
        linearLayoutManager.stackFromEnd = true
        recyclerView.layoutManager = linearLayoutManager // Add your recycler view to this ZoomRecycler layout
```

### Orientation Types

```kotlin
linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
```

### Use SnapHelper for Auto Center Views

```kotlin
 val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView) // Add your recycler view here
        recyclerView.isNestedScrollingEnabled = false
```

## My Implementation:

- [Main Activity- (Horizontal Orientation) ](./app/src/main/java/com/timac/zoomrecylerlayout/MainActivity.kt)

- [Vertical Activity- (Vertical Orientation) ](./app/src/main/java/com/timac/zoomrecylerlayout/VerticalActivity.kt)

- [activity_main](./app/src/main/res/layout/activity_main.xml)

- [activity_vertical](./app/src/main/res/layout/activity_vertical.xml)

- [RecyclerView Item](./app/src/main/res/layout/rv_item.xml)

## Screenshots

![Gif](https://media.giphy.com/media/YNlxRFRSiLUuQIdFDU/giphy.gif)