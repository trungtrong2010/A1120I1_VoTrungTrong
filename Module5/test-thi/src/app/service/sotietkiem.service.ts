import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ISoTietKiem} from '../model/ISoTietKiem';
import {IKhachHang} from '../model/IKhachHang';

@Injectable({
  providedIn: 'root'
})
export class SotietkiemService {

  constructor(private http: HttpClient) {
  }

  readonly SOTIETKIEM_API_URL = 'http://localhost:3000/soTietKiem';
  readonly KACHHANG_API_URL = 'http://localhost:3000/khachHang';

  getAllSoTietKiem(): Observable<ISoTietKiem[]> {
    return this.http.get<ISoTietKiem[]>(this.SOTIETKIEM_API_URL);
  }

  getAllKhachHang(): Observable<IKhachHang[]> {
    return this.http.get<IKhachHang[]>(this.KACHHANG_API_URL);
  }

  saveSoTietKiem(soTietKiem: ISoTietKiem): Observable<ISoTietKiem> {
    return this.http.post<ISoTietKiem>(this.SOTIETKIEM_API_URL, soTietKiem);
  }

  deleteSoTietKiem(id: number): Observable<ISoTietKiem> {
    return this.http.delete<ISoTietKiem>(this.SOTIETKIEM_API_URL + '/' + id);
  }

  updateSoTietKiem(soTietKiem: ISoTietKiem): Observable<ISoTietKiem[]> {
    return this.http.put<ISoTietKiem[]>(this.SOTIETKIEM_API_URL + '/' + soTietKiem.id, soTietKiem);
  }

  searchIdSoTietKiem(id: any): Observable<ISoTietKiem[]> {
    return this.http.get<ISoTietKiem[]>(this.SOTIETKIEM_API_URL + '?id_like=' + id);
  }
}
