select product_name
from netology.ORDERS o
  join netology.CUSTOMERS C
      on C.id = o.customer_id
where LOWER(name) LIKE 'alexey'
