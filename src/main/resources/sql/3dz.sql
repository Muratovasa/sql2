select product_name
from products.ORDERS o
  join produts.CUSTOMERS C
      on C.id = o.customer_id
where LOWER(name) = :name
