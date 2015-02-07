# Rotation

This projects demonstrates a strange behavior of the Android Activity lifecycle.

# The Example App

This example app is set up with `ParentActivity` and `ChildActivity`. `ParentActivity` has one button that launches
`ChildActivity`. `ChildActivity` has a transparent background so that `ParentActivity` isn't stopped when `ChildActivity`
starts. Both Activities are otherwise very vanilla.

# The Problem

When orientation change occurs after `ChildActivity` has been launched, locking the device results in only `ChildActivity.onStop()`
 being called, but not `ParentActivity.onStop()`. If no orientation change has occured, then both `ChildActivity.onStop()`
 and `ParentActivity.onStop()` are called when the device is locked.

### Normal Behavior
1. `ParentActivity.onStart()`
2. Launch Child
3. `ChildActivity.onStart()`
4. Lock the screen.
5. `ChildActivity.onStop()`
6. `ParentActivity.onStop()`

### Weird Behavior
1. `ParentActivity.onStart()`
2. Launch Child
3. `ChildActivity.onStart()`
4. Rotate the screen
5. `ChildActivity.onStop()`
6. `ChildActivity.onStart()`
7. `ParentActivity.onStop()`
8. `ParentActivity.onStart()`
9. Lock screen
10. `ChildActivity.onStop()`