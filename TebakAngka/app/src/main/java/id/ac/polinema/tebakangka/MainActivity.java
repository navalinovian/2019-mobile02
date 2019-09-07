package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText input;
	private Button tebak;
	private Button reset;
	private int random;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		input = findViewById(R.id.number_input);
		tebak = findViewById(R.id.guess_button);
		reset = findViewById(R.id.reset_button);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		random = new Random().nextInt(101);
	}

	@Override
	protected void onStart() {
		super.onStart();
		initRandomNumber();
		Toast.makeText(this,"Angka : " + random,Toast.LENGTH_SHORT).show();
	}

	public void handleGuess(View view) {
		  int tebakan = Integer.parseInt(String.valueOf(input.getText()));
		  if (tebakan == random ){
			  Toast.makeText(this,"Tebakan Anda benar!",Toast.LENGTH_SHORT).show();
			  tebak.setEnabled(false);
		  }else if (tebakan > random){
			  Toast.makeText(this,"Tebakan Anda terlalu besar!",Toast.LENGTH_SHORT).show();
			  input.setText("");
		  }else if (tebakan < random){
			  Toast.makeText(this,"Tebakan Anda terlalu kecil!",Toast.LENGTH_SHORT).show();
			  input.setText("");
		  }
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		Toast.makeText(this,"Angka : " + random,Toast.LENGTH_SHORT).show();
		tebak.setEnabled(true);
		input.setText("");
	}
}
