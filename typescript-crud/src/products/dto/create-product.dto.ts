import { IsNotEmpty, IsNumber, IsOptional, IsPositive, IsString } from 'class-validator';
import { ApiProperty, ApiPropertyOptional } from '@nestjs/swagger';

export class CreateProductDto {
  @ApiProperty({ description: 'Nome do produto' })
  @IsNotEmpty({ message: 'Nome é obrigatório' })
  @IsString()
  name: string;

  @ApiPropertyOptional({ description: 'Descrição do produto' })
  @IsOptional()
  @IsString()
  description?: string;

  @ApiProperty({ description: 'Preço do produto' })
  @IsPositive({ message: 'Preço deve ser maior que zero' })
  @IsNumber()
  price: number;

  @ApiPropertyOptional({ description: 'Quantidade em estoque' })
  @IsOptional()
  @IsNumber()
  quantity?: number;
} 