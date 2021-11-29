import {TypeCustomerDao} from './TypeCustomerDao';
import {Customer} from '../../model/customer/Customer';

export let CustomerDao: Customer[] = [
  {
    id : 1,
    typeCustomer : TypeCustomerDao[1],
    name : 'Võ Trung Trọng',
    // @ts-ignore
    dayOfBirthday : '1999-10-20',
    cccd : '206191220',
    phone: '0971718030',
    email : 'trungtrongcr21@gmail.com',
    address : 'Quảng Nam'
  },
  {
    id : 2,
    typeCustomer : TypeCustomerDao[2],
    name : 'Trọng Trọng Trọng',
    // @ts-ignore
    dayOfBirthday : '1999-10-20',
    cccd : '9999',
    phone: '0987654321',
    email : 'trungtrong99@gmail.com',
    address : 'Đà Nẵng'
  }
]
