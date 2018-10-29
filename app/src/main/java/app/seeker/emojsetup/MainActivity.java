package app.seeker.emojsetup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;
import hani.momanii.supernova_emoji_library.Helper.EmojiconTextView;

public class MainActivity extends AppCompatActivity {
private  static final String TAG =MainActivity.class.getSimpleName();
CheckBox checkBox;
EmojiconTextView textView ;
EmojiconEditText emojiconEditText;
ImageView imageView;
ImageView submitBtn;
View rootView;
EmojIconActions emojIconActions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.root_view);
        imageView = findViewById(R.id.emoji_btn);
        submitBtn =findViewById(R.id.submit_btn);
        checkBox = findViewById(R.id.use_system_default);
        emojiconEditText=findViewById(R.id.emojicon_edit_text);
        textView = findViewById(R.id.textView);

emojIconActions = new EmojIconActions(this,rootView,emojiconEditText,imageView);
emojIconActions.ShowEmojIcon();
emojIconActions.setIconsIds(R.drawable.ic_action_keyboard,R.drawable.smiley);

emojIconActions.setKeyboardListener(new EmojIconActions.KeyboardListener() {
    @Override
    public void onKeyboardOpen() {

    }

    @Override
    public void onKeyboardClose() {

    }
});

checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        emojIconActions.setUseSystemEmoji(isChecked);
        textView.setUseSystemDefault(isChecked);
    }
});

submitBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String test = emojiconEditText.getText().toString();
        textView.setText(test);
    }
});
    }
}
