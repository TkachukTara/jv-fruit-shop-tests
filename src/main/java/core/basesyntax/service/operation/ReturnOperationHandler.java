package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitDao;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperationHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void processTransaction(String fruit, Integer quantity) {
        if (quantity < 0) {
            throw new RuntimeException("Return fruit can`t be negative: " + quantity);
        }

        fruitDao.add(fruit, fruitDao.get(fruit) + quantity);
        System.out.println("Fruit: " + fruit + " ReturnOperationHandler: " + fruitDao.get(fruit));
    }
}
