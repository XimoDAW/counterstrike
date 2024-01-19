import { Component } from '@angular/core';
import { Player } from '../modelos/player';

@Component({
  selector: 'app-players',
  templateUrl: './players.component.html',
  styleUrls: ['./players.component.css']
})

export const PLAYERS: Player[] = {
  
};

export class PlayersComponent {
  
  players!: Player[] = PLAYERS
}
