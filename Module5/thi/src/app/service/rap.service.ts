import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {IRap} from '../model/IRap';
import {IPhim} from '../model/IPhim';

@Injectable({
  providedIn: 'root'
})
export class RapService {

  readonly RAP_API_URL = 'http://localhost:3000/rap';
  readonly PHIM_API_URL = 'http://localhost:3000/phim';

  constructor(private http: HttpClient) {
  }

  getAllRap(): Observable<IRap[]> {
    return this.http.get<IRap[]>(this.RAP_API_URL);
  }

  getAllPhim(): Observable<IPhim[]> {
    return this.http.get<IPhim[]>(this.PHIM_API_URL);
  }

  createRap(rap: IRap): Observable<IRap> {
    return this.http.post<IRap>(this.RAP_API_URL, rap);
  }

  deleteRap(rap: IRap): Observable<IRap> {
    return this.http.delete<IRap>(this.RAP_API_URL + '/' + rap.id);
  }
}
