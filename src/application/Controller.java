package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Controller {
	@FXML
	JFXButton txtInicio, txtPistas, txtReservas, txtContactar;
	
	@FXML
	AnchorPane paneMenu, panelGrande;
	
	@FXML
	Pane pane1, pane2, pane3, paneOscurecer;
	
	@FXML
	JFXHamburger btnMenu;
	
	
	public void initialize() {
		inicializarEventHandlers();
		paneMenu.setVisible(false);
		eliminarPanelMenu();
		fading();
	}

	private void inicializarEventHandlers() {
		txtInicio.setOnMouseEntered(event -> {
			hoverMenu(txtInicio);
		});
		
		txtInicio.setOnMouseExited(event -> {
			unHover(txtInicio);
		});
		

		txtPistas.setOnMouseEntered(event -> {
			hoverMenu(txtPistas);
		});
		
		txtPistas.setOnMouseExited(event -> {
			unHover(txtPistas);
		});
		
		
		txtReservas.setOnMouseEntered(event -> {
			hoverMenu(txtReservas);
		});
		
		txtReservas.setOnMouseExited(event -> {
			unHover(txtReservas);
		});
		
		txtContactar.setOnMouseEntered(event -> {
			hoverMenu(txtContactar);
		});
		
		txtContactar.setOnMouseExited(event -> {
			unHover(txtContactar);
		});
	}
	
	public void fading() {
		FadeTransition fade1 = new FadeTransition(Duration.seconds(5), pane3);
		fade1.setFromValue(1);
		fade1.setToValue(0);
		fade1.play();
		
		fade1.setOnFinished(event -> {
			FadeTransition fade2 = new FadeTransition(Duration.seconds(3), pane2);
			fade2.setFromValue(1);
			fade2.setToValue(0);
			fade2.play();
			
			fade2.setOnFinished(event2 -> {
				FadeTransition fade3 = new FadeTransition(Duration.seconds(3), pane2);
				fade3.setFromValue(0);
				fade3.setToValue(1);
				fade3.play();
				
				fade3.setOnFinished(event3 -> {
					FadeTransition fade4 = new FadeTransition(Duration.seconds(3), pane3);
					fade4.setFromValue(0);
					fade4.setToValue(1);
					fade4.play();
					
					fade4.setOnFinished(event4 -> {
						fading();
					});
				});
			});
		});
		
	}
	
	public void eliminarPanelMenu() {
		TranslateTransition eliminar = new TranslateTransition(Duration.seconds(0.2), paneMenu);
		eliminar.setByX(-600);
		eliminar.play();
	}
	
	public void visualizarPanelMenu() {
		if (paneOscurecer.isVisible()) {
			eliminarPanelMenu();
			paneOscurecer.setVisible(false);
			
		} else {
			paneMenu.setVisible(true);
			paneOscurecer.setVisible(true);
			FadeTransition fade1 = new FadeTransition(Duration.seconds(1), paneOscurecer);
			fade1.setFromValue(0);
			fade1.setToValue(0.6);
			fade1.play();
			
			TranslateTransition visualizar = new TranslateTransition(Duration.seconds(1), paneMenu);
			visualizar.setByX(600);
			visualizar.play();
		}
	}
	
	public void hoverMenu(JFXButton btn) {
			btn.setTextFill(Color.BLACK);
			btn.setStyle("-fx-background-color: white");		
	}
	
	public void unHover(JFXButton btn) {
		btn.setTextFill(Color.WHITE);
		btn.setStyle("-fx-background-color: black");	
	}
}
