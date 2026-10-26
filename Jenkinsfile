pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Build') {
            steps {
                echo '=== ЭТАП 1: Компиляция исходного кода ==='
                bat 'mvn compile'
            }
        }

        stage('Test') {
            steps {
                echo '=== ЭТАП 2: Запуск Unit-тестов ==='
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo '=== ЭТАП 3: Упаковка приложения в JAR-архив ==='
                bat 'mvn package -DskipTests'
            }
        }

        stage('Custom Maven Command (Dependency Tree)') {
            steps {
                echo '=== ЭТАП 4 (Индивидуальное задание): Вывод дерева зависимостей ==='
                bat 'mvn dependency:tree'
            }
        }
    }

    post {
        always {
            echo '=== Сборка завершена ==='
        }
        success {
            echo 'Конвейер выполнен успешно! Все этапы пройдены.'
        }
        failure {
            echo 'Ошибка при выполнении конвейера! Проверьте логи.'
        }
    }
}