import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PlayersComponent } from './players/players.component';
import { PlayerComponent } from './player/player.component';
import { ServersComponent } from './servers/servers.component';
import { ServerComponent } from './server/server.component';
import { TeamsComponent } from './teams/teams.component';
import { TeamComponent } from './team/team.component';
import { WeaponsComponent } from './weapons/weapons.component';
import { WeaponComponent } from './weapon/weapon.component';

@NgModule({
  declarations: [
    AppComponent,
    PlayersComponent,
    PlayerComponent,
    ServersComponent,
    ServerComponent,
    TeamsComponent,
    TeamComponent,
    WeaponsComponent,
    WeaponComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
