# passwordedittext

This is the implementation of an EditText user friendly for password inputs. It allows you to watch what are you writing using two modes: "on long press" and "onclick". It allows to personalize the icon you use for giving user feedbak


### Gradle Dependency

```Groovy
dependencies {
    compile 'com.github.gigigogreenlabs:passwordedittext:1.0.4'
}
```


Info: This library is still under development and could change.

### How to use

How to include lib in your XML views:
```HTML
    <us.gigigogreenlabs.passwordedittext.ShowHidePasswordView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/testpassword_edittext"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:show_type="on_click"
        >
    </us.gigigogreenlabs.passwordedittext.ShowHidePasswordView>
```
"show_type" attr allowed types : "on_click", "on_long_press"

How to set lock icon:

```java
    ShowHidePasswordView showHidePasswordView = (ShowHidePasswordView) findViewById(R.id.testpassword_edittext);
    showHidePasswordView.setImageResourceForLock(R.drawable.ic_lock_off, R.drawable.ic_lock_on);
```

Developed by
========

Gigigo Android Lab

License
=======

    Copyright 2015 Gigigo Android Lab.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
